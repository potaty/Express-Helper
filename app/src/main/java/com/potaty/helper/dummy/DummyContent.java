package com.potaty.helper.dummy;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private int COUNT = 4;

     /*   // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    */
    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
    public static void setList(JSONArray ja) {
        ITEM_MAP.clear();
        ITEMS.clear();
        try {
            for (int i = 0; i < ja.length(); ++i) {
                JSONObject jo = (JSONObject) ja.get(i);
                DummyItem di = new DummyItem(""+jo.getInt("id"), jo.getString("title"),jo.getString("address"), jo.getInt("status"));
                DummyContent.addItem(di);
                DummyContent.ITEM_MAP.put("" + jo.getInt("id"), di);
            }
        }catch(Exception e) {

        }
    }

/*
    private static DummyItem createDummyItem(int position) {
        String x = expressString[(int)(Math.random()*4)%4];
        int bi = (int)(Math.random() * 1099922990);
        return new DummyItem(String.valueOf(position),  x + " 快递编号: " +bi, makeDetails(position));
    }
*/
    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("您的快递,请扫描以下二维码或点击右侧按钮靠近机器扫描 NFC");
        //builder.append("\nMore details information here.");
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;
        public String details;
        public int status;

        public DummyItem(String id, String content, String details, int status) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.status = status;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
