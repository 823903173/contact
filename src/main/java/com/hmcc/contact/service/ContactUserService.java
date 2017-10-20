package com.hmcc.contact.service;

import com.hmcc.contact.entity.ContactAdmin;
import com.hmcc.contact.entity.ContactUser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * Created by TR on 2017/10/12.
 */
@Service
public interface ContactUserService {
    List<ContactUser> importExcelInfo(InputStream in, MultipartFile file,String contactAdminOrgId,Integer contactAdminNum)  throws Exception;
    List<ContactUser> DeleteExcelInfo(InputStream in, MultipartFile file)  throws Exception;

}

