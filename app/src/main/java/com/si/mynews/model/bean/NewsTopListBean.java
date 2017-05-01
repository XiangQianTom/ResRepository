package com.si.mynews.model.bean;

import java.io.Serializable;
import java.util.List;

/*
 * ==============================================================================
 *
 * 版 权 : ****
 *
 * 作 者 : 司 向 前
 *
 * 版 本 : 1.0
 *
 * 创建日期 : 2017/4/30 13:21
 *
 * 描 述 :
 *
 *
 *
 * 修订历史 :
 *
 * ==============================================================================
 */
public class NewsTopListBean {
    /**
     * data : [{"author_name":"小晖世界观","category":"头条","date":"2017-04-30 12:21","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170430/20170430_f84bb623f35d90991d7b49c0257f38dd_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170430/20170430_b6f8795c81059db629c8c0683decefab_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170430/20170430_7e14c284688756d47b11009e33601003_cover_mwpm_03200403.jpeg","title":"有这样的美女卖珠宝,不买你也会想坐下来聊聊啊","uniquekey":"8ccccad94900baefadc7e86b9a1f5aeb","url":"http://mini.eastday.com/mobile/170430122114357.html"},{"author_name":"澎湃新闻","category":"头条","date":"2017-04-30 12:19","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170430/20170430121944_ebee2dfa394962e47fede4424c96c942_1_mwpm_03200403.jpeg","title":"德国外长批特朗普家族\u201c裙带关系\u201d，行为犹如\u201c王室\u201d","uniquekey":"73c1e80fbc48e63cbd23c639b74c06f5","url":"http://mini.eastday.com/mobile/170430121944540.html"},{"author_name":"新华网","category":"头条","date":"2017-04-30 12:03","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170430/20170430120302_e8b554a4eb15941a5253e5f50494b503_4_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170430/20170430120302_e8b554a4eb15941a5253e5f50494b503_1_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170430/20170430120302_e8b554a4eb15941a5253e5f50494b503_2_mwpm_03200403.jpeg","title":"内蒙古大巴轿车相撞事故死亡人数已增至12人","uniquekey":"b329e57c21456c42a8a14ecd96ee99f0","url":"http://mini.eastday.com/mobile/170430120302551.html"}]
     * stat : 1
     */

    private String stat;
    private List<DataBean> data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * author_name : 小晖世界观
         * category : 头条
         * date : 2017-04-30 12:21
         * thumbnail_pic_s : http://06.imgmini.eastday.com/mobile/20170430/20170430_f84bb623f35d90991d7b49c0257f38dd_cover_mwpm_03200403.jpeg
         * thumbnail_pic_s02 : http://06.imgmini.eastday.com/mobile/20170430/20170430_b6f8795c81059db629c8c0683decefab_cover_mwpm_03200403.jpeg
         * thumbnail_pic_s03 : http://06.imgmini.eastday.com/mobile/20170430/20170430_7e14c284688756d47b11009e33601003_cover_mwpm_03200403.jpeg
         * title : 有这样的美女卖珠宝,不买你也会想坐下来聊聊啊
         * uniquekey : 8ccccad94900baefadc7e86b9a1f5aeb
         * url : http://mini.eastday.com/mobile/170430122114357.html
         */

        private String author_name;
        private String category;
        private String date;
        private String thumbnail_pic_s;
        private String thumbnail_pic_s02;
        private String thumbnail_pic_s03;
        private String title;
        private String uniquekey;
        private String url;

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getThumbnail_pic_s() {
            return thumbnail_pic_s;
        }

        public void setThumbnail_pic_s(String thumbnail_pic_s) {
            this.thumbnail_pic_s = thumbnail_pic_s;
        }

        public String getThumbnail_pic_s02() {
            return thumbnail_pic_s02;
        }

        public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
            this.thumbnail_pic_s02 = thumbnail_pic_s02;
        }

        public String getThumbnail_pic_s03() {
            return thumbnail_pic_s03;
        }

        public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
            this.thumbnail_pic_s03 = thumbnail_pic_s03;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUniquekey() {
            return uniquekey;
        }

        public void setUniquekey(String uniquekey) {
            this.uniquekey = uniquekey;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
