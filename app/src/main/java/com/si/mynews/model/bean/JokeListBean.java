package com.si.mynews.model.bean;

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
 * 创建日期 : 2017/5/3 21:46
 *
 * 描 述 :
 *
 *
 *
 * 修订历史 :
 *
 * ==============================================================================
 */
public class JokeListBean {
    /**
     * list : [{"addtime":"2017-05-04 02:40:02","content":"五块钱一摸 十块钱一操 十五全套 二十一宿 三十包月 二块一套 八块一抱 十二一亲 三百包年。 需要的评论 卖 身 啦 ！！！！！","url":"http://m.kaixinhui.com/detail-51942.html"},{"addtime":"2017-05-04 02:40:02","content":"一次老王在背把我眼睛遮住说猜猜我是谁，我说老王吧(老王八)老王二话不说就打我i。","url":"http://m.kaixinhui.com/detail-51941.html"},{"addtime":"2017-05-04 02:40:02","content":"老公:老婆如果你不逗比，你也不会淑女的\u201d老婆:玛德，老娘我是走女神路线的不是淑女路线的，白痴。","url":"http://m.kaixinhui.com/detail-51940.html"},{"addtime":"2017-05-04 02:40:02","content":"老师:谁能告诉我古代的四大美人是谁？小明连忙举手回答:我知道，是美人鱼、白雪公主、灰姑娘、白素贞。老师:\u2026\u2026","url":"http://m.kaixinhui.com/detail-51939.html"},{"addtime":"2017-05-04 02:40:02","content":"老师:谁会用一句简单的话来说说我的特点，小宁:为人正直，讲诚信，小燕:老师很爱笑，是个阳光的美女，老师很满意同学的回答，这时候小明站起来回答:老师脾气暴躁二百五，不是人。老师:你给我滚。","url":"http://m.kaixinhui.com/detail-51938.html"},{"addtime":"2017-05-04 02:40:02","content":"老师:小鹏，你能用\u201d可能\u201d这两个字造句吗？小鹏:能，这个太简单了。老师高兴极了:小鹏，真聪明你可以造句了！小鹏:我可能爱上老师你了，我想将来娶你！老师:我靠","url":"http://m.kaixinhui.com/detail-51937.html"},{"addtime":"2017-04-27 02:40:01","content":"老师:小明同学你能赞美自己身边的人，任何人都行。小明:哦，知道，我想赞美老师您；老师很高兴，笑着说到:好啊，小明真好说说吧你是怎么赞美我的，小明:老师老师不美丽，大黑脖子红外衣，水桶呀黑臭脚，要说丑陋您第一。","url":"http://m.kaixinhui.com/detail-51936.html"},{"addtime":"2017-04-27 02:40:01","content":"小红说:\u201c小明你头上有蜘蛛。\u201d小明说:\u201c你头上才有只猪。\u201d小红哭着跑走了，蜘蛛把小明给杀了。","url":"http://m.kaixinhui.com/detail-51935.html"},{"addtime":"2017-04-27 02:40:01","content":"昨天，一名警察看见一个美女没穿胸罩和内裤，上去就说姑娘你想被车撞吗？姑娘扇一个大嘴巴，给这位警察扇懵了。其他警察都乐他。","url":"http://m.kaixinhui.com/detail-51934.html"},{"addtime":"2017-04-27 02:40:01","content":"、昨晚下班后，和哥们一起去跑步，跑一半发现肚子疼得厉害，就对他说，你去帮我买包纸，我去趟厕所。等了快半小时了也不见他来，腿也软了，熏得也不行了，厕所也没人，眼看实在没招了，就把内裤脱下来擦屁股，心想着出去弄死你。 走到门口看见他拿着包子说：你怎么才出来，包子都凉了。 我@#￥@#￥","url":"http://m.kaixinhui.com/detail-51933.html"}]
     * pagenum : 1
     * pagesize : 10
     * total : 47135
     */
    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * addtime : 2017-05-04 02:40:02
         * content : 五块钱一摸 十块钱一操 十五全套 二十一宿 三十包月 二块一套 八块一抱 十二一亲 三百包年。 需要的评论 卖 身 啦 ！！！！！
         * url : http://m.kaixinhui.com/detail-51942.html
         */
        private String addtime;
        private String content;
        private String url;

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
