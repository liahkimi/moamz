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
    private String fgCertContent;
    private Long fgProjectId;
}
