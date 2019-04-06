package cn.org.july.web.controller.test;

import cn.org.july.web.common.json.JSONObject;

public enum StatusEnum {
    FAIL("失败", "300", "认证系统"),
    OK("成功", "200", "认证系统");

    private final String msg;
    private final String status;
    private final String code;

    StatusEnum(String msg, String status, String code) {
        this.msg = msg;
        this.status = status;
        this.code = code;
    }
//    @Override
//    public String getMsg() {
//        return this.msg;
//    }
//    @Override
//    public String getStatus() {
//        return this.status;
//    }
//    @Override
//    public String getCode() {
//        return this.code;
//    }

    public String toJson() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg",this.msg);
        jsonObject.put("status",this.status);
        jsonObject.put("code",this.code);
        return jsonObject.toCompactString();
    }

    public static void main(String[] args) throws Exception {

        System.out.println(StatusEnum.OK.toJson());

//        IStatusEnum statusEnum = StatusEnum.FAIL;
//        System.out.println(statusEnum.getCode());
//        System.out.println(statusEnum.getMsg());
//        System.out.println(statusEnum.getStatus());
//        IStatusEnum statusEnumOk = StatusEnum.OK;
//        System.out.println(statusEnumOk.getCode());
//        System.out.println(statusEnumOk.getMsg());
//        System.out.println(statusEnumOk.getStatus());
    }


}
