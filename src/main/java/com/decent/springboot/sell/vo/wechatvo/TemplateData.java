package com.decent.springboot.sell.vo.wechatvo;

import lombok.Data;

/**
 * @author jiangyu
 * @date 2019/6/26 21:28
 * @email jiangyu9633@foxmail.com
 */
@Data
public class TemplateData {
    private TemplateSingleInfoVo first;
    private TemplateSingleInfoVo keyword1;
    private TemplateSingleInfoVo keyword2;
    private TemplateSingleInfoVo keyword3;
    private TemplateSingleInfoVo remark;
}