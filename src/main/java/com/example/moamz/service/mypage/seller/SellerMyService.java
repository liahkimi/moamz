package com.example.moamz.service.mypage.seller;

import com.example.moamz.domain.dto.file.PostFileDTO;
import com.example.moamz.domain.dto.file.UserFileDTO;
import com.example.moamz.domain.dto.mypage.seller.StoreReviewDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerInfoDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreInfoDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreModifyDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.mapper.file.UserFileMapper;
import com.example.moamz.mapper.mypage.seller.SellerMyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerMyService {
    private final SellerMyMapper sellerMyMapper;
    private final UserFileMapper userFileMapper;

    /////////////////////////////////////////////////////////
    ///// 파일 처리 메서드

    // fileDir 필드에 application.properties에 저장해둔 file.dir 프로퍼티 값 넣어줌
    @Value("C:/upload_moamz/")
    private String fileDir;

    // 파일 업로드 경로를 생성 메서드
    private String getUploadPath() {
        // 날짜 형식으로 폴더 경로를 생성함
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }


    // 파일 저장 메서드
    public UserFileDTO saveFile(MultipartFile file) throws IOException {
        // 사용자가 올린 파일명과 UUID를 합쳐서 파일을 저장함
        String originalFileName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String systemName = uuid.toString() + "_" + originalFileName;

        // 상위 경로와 하위 경로를 합쳐서 파일이 저장될 경로 생성
        File uploadPath = new File(fileDir + getUploadPath());

        // 경로가 존재하지 않으면 폴더를 생성함
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        // 전체 경로와 파일 이름을 연결하여 최종 경로를 설정함
        File uploadFile = new File(uploadPath, systemName);

        // 매개변수로 받은 Multipart 객체가 가진 파일을 우리가 만든 경로와 이름으로 저장한다
        file.transferTo(uploadFile);

        UserFileDTO userFileDTO = new UserFileDTO();
        userFileDTO.setUserFileUuid(uuid.toString());
        userFileDTO.setUserFileName(originalFileName);
        userFileDTO.setUserFileRoot(getUploadPath());
        return userFileDTO;
    }



    /////////////////////////////////////////////////////////
    ///// 판매자 회원 관련 메서드

    // 판매자 프로필 가져오기 메서드
    public SellerProfileDTO getSellerProfile(Long businessId, Long userCode) {

        // 판매자 프로필 조회
        SellerProfileDTO sellerProfileDTO = sellerMyMapper.selectStoreProfile(userCode);

        // 우수 업체 여부
        String isExcellent = sellerMyMapper.selectExcellentStore(businessId);

        // 우수업체인 경우 DTO에 topBusiness값 설정하기
        if(isExcellent.equals("TRUE")) {
            sellerProfileDTO.setIsTopBusiness("우수업체");
        }

        // 구해준 음식물 누적합계 g -> kg으로 변환
        int totalWeight = sellerProfileDTO.getTotalWeight();
        sellerProfileDTO.setTotalWeightToKg((double) totalWeight/1000 );

        // 탄소감축량, 나무 수 계산
        double carbonReduct = totalWeight * 0.0025;
        double treeCount = carbonReduct / 22;

        // DTO에 탄소감축량, 나무 수 필드값 설정하기
        sellerProfileDTO.setCarbonReduction(carbonReduct);
        sellerProfileDTO.setTreeCount(treeCount);

        return sellerProfileDTO;
    }

    // 업체 리뷰 조회 메서드
    public List<StoreReviewDTO> findMyStoreRv(Long businessId) {
        return sellerMyMapper.selectMyStoreRv(businessId);
    }

    // 업체 리뷰 조회 메서드 (페이지네이션 O)
    public List<StoreReviewDTO> findMyStoreRvAll(Long businessId, Criteria criteria) {
        return sellerMyMapper.selectMyStoreRvAll(businessId, criteria);
    }

    // 전체 리뷰 수 세는 메서드
    public int findTotal(Long businessId) {
        return sellerMyMapper.selectTotal(businessId);
    }

    // 판매자 업체 번호 반환 메서드
    public Long findBusinessId(Long userCode) {
        return sellerMyMapper.selectBusinessId(userCode).
                orElseThrow(() -> new IllegalStateException("❌❌❌존재하지 않는 업체"));
    }

    // 유저 아이디 반환 메서드
    public String findSellerId(Long userCode) {
        return sellerMyMapper.selectSellerId(userCode);
    }

    // 회원 비밀번호 조회 메서드
    public String findSellerPw(Long userCode) {
        return sellerMyMapper.selectSellerPw(userCode)
                .orElseThrow(() -> new IllegalStateException("❌❌❌존재하지 않는 회원정보"));
    }

    // 개인정보 가져오기 메서드
    public SellerInfoDTO findSellerInfo(Long userCode) {
        return sellerMyMapper.selectSellerInfo(userCode);
    }

    // 휴대폰번호 조회하기 메서드
    public String findSellerPhone(Long userCode) {
        return sellerMyMapper.selectSellerPhone(userCode);
    }
    // 휴대폰번호 변경 메서드
    public void updateSellerPhone(@Param("inputPhone") String inputPhone, @Param("userCode") Long userCode) {
        sellerMyMapper.modifySellerPhone(inputPhone, userCode);
    }

    // 비밀번호 변경 메서드
    public void updateSellerPassword(@Param("inputPw") String inputPw, @Param("userCode") Long userCode) {
        sellerMyMapper.modifySellerPw(inputPw, userCode);
    }

    // 업체정보 가져오기 메서드
    public StoreInfoDTO findStoreInfo(Long userCode) {
        return sellerMyMapper.selectStoreInfo(userCode);
    }

    // 업체 정보 변경하기 메서드 (파일처리 포함)
    public void updateStoreInfo(Long userCode,
                                StoreModifyDTO storeModifyDTO,
                                MultipartFile file,
                                boolean fileChanged) throws IOException {

        // 업체 정보 수정 쿼리문 실행
        sellerMyMapper.modifyStoreInfo(storeModifyDTO);

        // 대표사진이 변경되었을 때, 파일 삭제 후 재등록 해준다.
        if(fileChanged) {
            // 기존 파일을 삭제한다.
            userFileMapper.deleteFile(userCode);

            if(!file.isEmpty()) {
                UserFileDTO userFileDTO = saveFile(file);
                userFileDTO.setUserCode(userCode);
                // 새 파일 등록 쿼리문 실행
                userFileMapper.insertFile(userFileDTO);
            }
        }
    }

    // 회원 탈퇴 메서드
    public void removeUser(Long userCode) {
        sellerMyMapper.deleteUser(userCode);
    }

    // 탈퇴 가능한 회원인지 조회
    public int findWithdrawAvailable(Long businessId) {
        return sellerMyMapper.selectWithdrawAvailable(businessId);
    }
}
