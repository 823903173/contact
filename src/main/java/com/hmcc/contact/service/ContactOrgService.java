package com.hmcc.contact.service;

import com.hmcc.contact.entity.ContactOrg;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * Created by TR on 2017/10/18.
 */
@Service
public interface ContactOrgService {
    List<ContactOrg> importExcelInfo(InputStream in, MultipartFile file,String contactAdminOrgId,Integer contactAdminNum)  throws Exception;
    List<ContactOrg> DeleteExcelInfo(InputStream in, MultipartFile file,String contactAdminOrgId,Integer contactAdminNum)  throws Exception;
}
