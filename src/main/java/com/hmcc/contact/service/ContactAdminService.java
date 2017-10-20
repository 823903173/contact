package com.hmcc.contact.service;

import com.hmcc.contact.entity.ContactAdmin;
import com.hmcc.contact.entity.ContactOrg;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tools.ExcelUtilContact;

import java.io.InputStream;
import java.util.List;

/**
 * Created by TR on 2017/10/17.
 */
@Service
public interface ContactAdminService {
    List<ContactAdmin> importExcelInfo(InputStream in, MultipartFile file,String contactAdminOrgId,Integer contactAdminNum)  throws Exception;
    List<ContactAdmin> DeleteExcelInfo(InputStream in, MultipartFile file,String contactAdminOrgId,Integer contactAdminNum)  throws Exception;
    ContactAdmin getAdmin(Long phoneNum)throws Exception;

}
