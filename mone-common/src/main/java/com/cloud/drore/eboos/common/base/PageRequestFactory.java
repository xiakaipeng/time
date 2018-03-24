package com.cloud.drore.eboos.common.base;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * User: wcy
 * Date: 2017/10/27
 * Time: 15:56
 */
public class PageRequestFactory {

    public static final char UNDERLINE='_';

    private PageRequestFactory(){}

    public static PageRequest getPageInfo(PagePo po){
//        String sortFields = underline2Camel(po.getSortFields());
//        return new PageRequest(po.getPageNum(),
//                po.getPageSize(),
//                new Sort(Sort.Direction.valueOf(po.getSortType()),sortFields));
        return null;
    }

    public static String underline2Camel(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (c==UNDERLINE){
                if (++i<len){
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
