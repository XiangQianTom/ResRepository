package com.si.mynews.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by si on 16/11/27.
 */

public class NewsListBean {

    /**
     * channel : 头条
     * list : [{"category":"sports","content":"北京","pic":"http://api.jisuapi.com/news/upload/20170425/210007_96042.jpg","src":"新浪体育","time":"2017-04-25 13:20","title":"37+8+7+7三分！库里照死了虐","url":"http://sports.sina.cn/nba/warriors/2017-04-25/detail-ifyepsec0948058.d.html?vt=4&pos=108","weburl":"http://sports.sina.com.cn/basketball/nba/2017-04-25/doc-ifyepsec0948058.shtml"},{"category":"sports","content":"北京时间","pic":"http://api.jisuapi.com/news/upload/20170425/210006_11038.jpg","src":"新浪体育","time":"2017-04-25 13:14","title":"库里37分阿杜复出勇士横扫","url":"http://sports.sina.cn/nba/warriors/2017-04-25/detail-ifyepsch3194860.d.html?vt=4&pos=108","weburl":"http://sports.sina.com.cn/basketball/nba/2017-04-25/doc-ifyepsch3194860.shtml"},{"category":"sports","content":"北京","pic":"http://api.jisuapi.com/news/upload/20170425/210006_82282.jpg","src":"新浪体育","time":"2017-04-25 17:31","title":"全运预赛-福建1分险胜山东","url":"http://sports.sina.cn/cba/2017-04-25/detail-ifyepsch3267740.d.html?vt=4&pos=108","weburl":"http://sports.sina.com.cn/cba/2017-04-25/doc-ifyepsch3267740.shtml"},{"category":"sports","content":"北京时间","pic":"http://api.jisuapi.com/news/upload/20170425/210006_10200.jpg","src":"新浪体育","time":"2017-04-25 20:04","title":"联赛广东铁板凳肆虐北京内线","url":"http://sports.sina.cn/cba/2017-04-25/detail-ifyepsec1058699.d.html?vt=4&pos=108","weburl":"http://sports.sina.com.cn/cba/2017-04-25/doc-ifyepsec1058699.shtml"},{"category":"sports","content":"文至少在签约经纪公司这一点上，他已经先站在了巨人的肩膀上","pic":"http://api.jisuapi.com/news/upload/20170425/210003_58491.jpg","src":"体坛+","time":"2017-04-25 16:11","title":"体坛+：赵继伟确实想参加选秀","url":"http://sports.sina.cn/cba/2017-04-25/detail-ifyepsec0997775.d.html?vt=4&pos=108","weburl":"http://sports.sina.com.cn/cba/2017-04-25/doc-ifyepsec0997775.shtml"},{"category":"sports","content":"没有什么比球队成绩糟糕军心动摇的时候，老总出面力挺所","pic":"http://api.jisuapi.com/news/upload/20170425/210002_36606.jpg","src":"新浪体育","time":"2017-04-25 16:13","title":"韩球迷热议苏宁老总力挺崔帅","url":"http://sports.sina.cn/china/2017-04-25/detail-ifyepsec0998121.d.html?vt=4&pos=108","weburl":"http://sports.sina.com.cn/china/afccl/2017-04-25/doc-ifyepsec0998121.shtml"},{"category":"news","content":"原标题力的制裁","pic":"http://api.jisuapi.com/news/upload/20170425/210002_23224.jpg","src":"新华网","time":"2017-04-25 18:40","title":"朝鲜谴责美对朝孤立扼杀政策","url":"http://news.sina.cn/2017-04-25/detail-ifyepsra5567678.d.html?vt=4&pos=108","weburl":"http://news.sina.com.cn/o/2017-04-25/doc-ifyepsra5567678.shtml"},{"category":"ent","content":"新浪娱乐讯 近日有网友爆她道歉，\u201c因为她知道狗仔队是不会跟拍我","pic":"http://api.jisuapi.com/news/upload/20170425/210002_80246.jpg","src":"新浪娱乐","time":"2017-04-25 20:17","title":"曝陈思诚美国约会小3互叫宝宝","url":"http://ent.sina.cn/star/tv/2017-04-25/detail-ifyepsec1061312.d.html?vt=4&pos=108","weburl":"http://ent.sina.com.cn/s/m/2017-04-25/doc-ifyepsec1061312.shtml"},{"category":"finance","content":"董明珠","pic":"http://api.jisuapi.com/news/upload/20170425/200003_30084.jpg","src":"综合","time":"2017-04-25 19:26","title":"董明珠:你没成功而只是到头了","url":"http://finance.sina.cn/chanjing/gsxw/2017-04-25/detail-ifyepsec1051577.d.html?vt=4&pos=108","weburl":"http://finance.sina.com.cn/chanjing/gsnews/2017-04-25/doc-ifyepsec1051577.shtml"},{"category":"ent","content":"新浪娱乐讯","pic":"http://api.jisuapi.com/news/upload/20170425/200003_71768.jpg","src":"新浪娱乐","time":"2017-04-25 15:14","title":"谢霆锋回应和王菲签分手协议","url":"http://ent.sina.cn/star/hk_tw/2017-04-25/detail-ifyepsch3227097.d.html?vt=4&pos=108","weburl":"http://ent.sina.com.cn/s/h/2017-04-25/doc-ifyepsch3227097.shtml"}]
     * num : 10
     */

    private String channel;
    private String num;
    private List<ListBean> list;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable {
        /**
         * category : sports
         * content : 北京
         * pic : http://api.jisuapi.com/news/upload/20170425/210007_96042.jpg
         * src : 新浪体育
         * time : 2017-04-25 13:20
         * title : 37+8+7+7三分！库里照死了虐
         * url : http://sports.sina.cn/nba/warriors/2017-04-25/detail-ifyepsec0948058.d.html?vt=4&pos=108
         * weburl : http://sports.sina.com.cn/basketball/nba/2017-04-25/doc-ifyepsec0948058.shtml
         */

        private String category;
        private String content;
        private String pic;
        private String src;
        private String time;
        private String title;
        private String url;
        private String weburl;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }
    }
}