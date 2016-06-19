package com.wonder.zhihuibeijing.domain;

import java.util.ArrayList;

/**
 * Created by 13036 on 2016/6/17.
 */
public class NewsMenu {
    public int recode;

    public ArrayList<Integer> extend;

    public ArrayList<NewsMenuData> data;

    public class NewsMenuData {
        public int id;
        public String title;
        public int type;

        public ArrayList<NewsTabData> children;

        @Override
        public String toString() {
            return "NewsMenuData{" +
                    "title='" + title + '\'' +
                    ", children=" + children +
                    '}';
        }
    }

    public class NewsTabData {
        public int id;
        public String title;
        public int type;

        @Override
        public String toString() {
            return "NewsTabData{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NewsMenu{" +
                "data=" + data +
                '}';
    }
}
