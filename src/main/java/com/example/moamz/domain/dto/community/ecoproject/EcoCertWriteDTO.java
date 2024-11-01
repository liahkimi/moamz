package com.example.moamz.domain.dto.community.ecoproject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EcoCertWriteDTO {
    private Long fgPostId;
    private Long fgProjectId;
    private String fgCommonUserCode;
    private String fgPostContent;
    private String fgPostFileName;
    private String fgPostFileUuid;
    private String fgPostFileRoot;
}
