package com.cloud.drore.eboss.operation.mapper.provider;


import com.cloud.drore.eboss.operation.entity.POIOperation;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: poi的provider<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 5:03 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class POIProvider {
    public String updatePOI(POIOperation POIOperation) {
        String sql = "update eboos_poi set";
        int count = 0;
        if (!("".equals(POIOperation.getLinkMan()) || null == POIOperation.getLinkMan())) {
            sql += " link_man='" + POIOperation.getLinkMan() + "'";

            count++;
        }
        if (!("".equals(POIOperation.getTelephone()) || null == POIOperation.getTelephone())) {
            if (count != 0) {
                sql += ",";
            }
            sql += " telephone='" + POIOperation.getTelephone() + "'";

            count++;
        }
        if (!("".equals(POIOperation.getOpenTime()) || null == POIOperation.getOpenTime())) {
            if (count != 0) {
                sql += ",";
            }
            sql += " open_time='" + POIOperation.getOpenTime() + "'";

            count++;
        }
        if (!("".equals(POIOperation.getEndTime()) || null == POIOperation.getEndTime())) {
            if (count != 0) {
                sql += ",";
            }
            sql += " end_time='" + POIOperation.getEndTime() + "'";

            count++;
        }
        if (!("".equals(POIOperation.getCustomerTel()) || null == POIOperation.getCustomerTel())) {
            if (count != 0) {
                sql += ",";
            }
            sql += " customer_tel='" + POIOperation.getCustomerTel() + "'";

            count++;
        }
        if (!("".equals(POIOperation.getCovermapUrl()) || null == POIOperation.getCovermapUrl())) {
            if (count != 0) {
                sql += ",";
            }
            sql += " covermap_url='" + POIOperation.getCovermapUrl() + "'";

            count++;
        }
        if (!("".equals(POIOperation.getCovermapSquareUrl()) || null == POIOperation.getCovermapSquareUrl())) {
            if (count != 0) {
                sql += ",";
            }
            sql += " covermap_square_url='" + POIOperation.getCovermapSquareUrl() + "'";

            count++;
        }
        if (!("".equals(POIOperation.getAlbumUrl()) || null == POIOperation.getAlbumUrl())) {
            if (count != 0) {
                sql += ",";
            }
            sql += " album_url='" + POIOperation.getAlbumUrl() + "'";

            count++;
        }
        if (!("".equals(POIOperation.getScenicaIntroductionText()) || null == POIOperation.getScenicaIntroductionText())) {
            if (count != 0) {
                sql += ",";
            }
            sql += " scenica_introduction_text='" + POIOperation.getScenicaIntroductionText() + "'";

            count++;
        }
        if (!("".equals(POIOperation.getVerificationInstructions()) || null == POIOperation.getVerificationInstructions())) {
            if (count != 0) {
                sql += ",";
            }
            sql += " verification_instructions='" + POIOperation.getVerificationInstructions() + "'";
            count++;
        }

        sql += " where id=" + POIOperation.getId();
        return sql;
    }
}
