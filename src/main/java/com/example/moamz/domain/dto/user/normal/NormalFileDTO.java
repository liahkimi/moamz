package com.example.moamz.domain.dto.user.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor
public class NormalFileDTO {
    private String fgFileId;
    private String fgFileName;
    private String fgFileRoot;
    private String fgFileTime;
    private String fgFileUuid;
    private Long fgUserCode;
}
