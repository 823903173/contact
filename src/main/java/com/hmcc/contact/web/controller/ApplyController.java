//package com.hmcc.contact.web.controller;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//
///**
// * Created by a8239 on 2017/10/12.
// */
//@RestController
//@RequestMapping("/app")
//public class ApplyController {
//
//    @RequestMapping(value = "/file", method = RequestMethod.POST)
//    public @ResponseBody AjaxResult batchimport(@RequestParam(value="file") MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception{
//        AjaxResult result = null;
//        System.out.println("fileName--->"+file.getOriginalFilename());
//        if(!file.isEmpty()){
//            String path=file.getOriginalFilename();
//            System.out.println(path+"-------------------------------");
//            FileOutputStream os = new FileOutputStream("D:/"+file.getOriginalFilename());
//            InputStream in = file.getInputStream();
//            int b=0;
//            while((b=in.read())!=-1){
//                os.write(b);
//            }
//            os.flush();
//            os.close();
//            in.close();
//
//            String excel="D:/"+path;
//            System.out.println(excel+"--------------------------------");
//
//            Object[] data = new Object[2];
//            data = new ReadExcel().readExcel(excel);
//            if (null != data) {
//                result = new AjaxResult(1, data);
//            } else {
//                result = new AjaxResult(0, "修改失败!");
//            }
//            result.setData(data);
//
//
//        }
//        return result;
//
//
//    public void getOneAll(String id)
//    {
////        AddresslistUser user =  iAddresslistUserService.getOneInfo(Integer.parseInt(id));
//        return ;
//
//    }
//
//
//}
//
//
//
//
