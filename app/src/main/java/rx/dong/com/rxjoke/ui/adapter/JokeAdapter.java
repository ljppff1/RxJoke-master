package rx.dong.com.rxjoke.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.dong.com.rxjoke.R;
import rx.dong.com.rxjoke.model.ContentlistEntity;
import rx.dong.com.rxjoke.util.TimeUtil;

/**
 * Created by JDD on 2016/4/23 0023.
 */
public class JokeAdapter extends RecyclerView.Adapter {

    private List<ContentlistEntity> jokeList;

    public JokeAdapter(List<ContentlistEntity> jokeList) {
        this.jokeList = jokeList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.r5joke_list_item,
                parent, false);
        JokeViewHolder holder = new JokeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        JokeViewHolder jokeViewHolder = (JokeViewHolder) holder;
        jokeViewHolder.title.setText("#" + jokeList.get(position).getTitle() + "#");
        jokeViewHolder.time.setText(TimeUtil.getDateBySplit(jokeList.get(position).getCt()));
        /*使html中<标签>得以转化*/
        if(position==1){
            jokeViewHolder.content.setText(Html.fromHtml("  <div class=\"H-overflow-scrolling H-margin-10 H-position-relative\">\n" +
                    "        <table class=\"H-table H-table-fixed H-theme-background-color-white H-border-vertical-top-after H-border-horizontal-left-after\">\n" +
                    "            <thead>\n" +
                    "                <tr>\n" +
                    "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">流水号</th>\n" +
                    "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">产品名称</th>\n" +
                    "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">销售价格</th>\n" +
                    "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">生产日期</th>\n" +
                    "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">保质期</th>\n" +
                    "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">生产商</th>\n" +
                    "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">操作</th>\n" +
                    "                </tr>\n" +
                    "            </thead>\n" +
                    "            <tbody>\n" +
                    "                <tr>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">000000012</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">300ML 可口可乐</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">￥3.50</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2016-05-15</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2018-05-15</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">中山赢友网络科技有限公司</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\"><span tapmode=\"\" onclick=\"H.toastTip('功能开发中...');\" class=\"H-display-inline-block H-padding-horizontal-both-5 H-theme-font-color1\">编辑</span><span tapmode=\"\" onclick=\"H.confirmTip(function (ret, err) { if (ret.buttonIndex == 1) { H.toastSuccess(); } }, '删除提示：','您确定要删除此记录吗？');\" class=\"H-display-inline-block H-padding-horizontal-both-5 H-theme-font-color-red\">删除</span></td>\n" +
                    "                </tr>\n" +
                    "                <tr>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">000000012</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">300ML 可口可乐</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">￥3.50</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2016-05-15</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2018-05-15</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">中山赢友网络科技有限公司</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\"><span tapmode=\"\" onclick=\"H.toastTip('功能开发中...');\" class=\"H-display-inline-block H-padding-horizontal-both-5 H-theme-font-color1\">编辑</span><span tapmode=\"\" onclick=\"H.confirmTip(function (ret, err) { if (ret.buttonIndex == 1) { H.toastSuccess(); } }, '删除提示：','您确定要删除此记录吗？');\" class=\"H-display-inline-block H-padding-horizontal-both-5 H-theme-font-color-red\">删除</span></td>\n" +
                    "                </tr>\n" +
                    "                <tr>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">000000012</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">300ML 可口可乐</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">￥3.50</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2016-05-15</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2018-05-15</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">中山赢友网络科技有限公司</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\"><span tapmode=\"\" onclick=\"H.toastTip('功能开发中...');\" class=\"H-display-inline-block H-padding-horizontal-both-5 H-theme-font-color1\">编辑</span><span tapmode=\"\" onclick=\"H.confirmTip(function (ret, err) { if (ret.buttonIndex == 1) { H.toastSuccess(); } }, '删除提示：','您确定要删除此记录吗？');\" class=\"H-display-inline-block H-padding-horizontal-both-5 H-theme-font-color-red\">删除</span></td>\n" +
                    "                </tr>\n" +
                    "                <tr>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">000000012</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">300ML 可口可乐</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">￥3.50</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2016-05-15</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2018-05-15</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">中山赢友网络科技有限公司</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\"><span tapmode=\"\" onclick=\"H.toastTip('功能开发中...');\" class=\"H-display-inline-block H-padding-horizontal-both-5 H-theme-font-color1\">编辑</span><span tapmode=\"\" onclick=\"H.confirmTip(function (ret, err) { if (ret.buttonIndex == 1) { H.toastSuccess(); } }, '删除提示：','您确定要删除此记录吗？');\" class=\"H-display-inline-block H-padding-horizontal-both-5 H-theme-font-color-red\">删除</span></td>\n" +
                    "                </tr>\n" +
                    "                <tr>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">000000012</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">300ML 可口可乐</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">￥3.50</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2016-05-15</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2018-05-15</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">中山赢友网络科技有限公司</td>\n" +
                    "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\"><span tapmode=\"\" onclick=\"H.toastTip('功能开发中...');\" class=\"H-display-inline-block H-padding-horizontal-both-5 H-theme-font-color1\">编辑</span><span tapmode=\"\" onclick=\"H.confirmTip(function (ret, err) { if (ret.buttonIndex == 1) { H.toastSuccess(); } }, '删除提示：','您确定要删除此记录吗？');\" class=\"H-display-inline-block H-padding-horizontal-both-5 H-theme-font-color-red\">删除</span></td>\n" +
                    "                </tr>\n" +
                    "            </tbody>\n" +
                    "        </table>\n" +
                    "    </div>"));
        }else {
            jokeViewHolder.content.setText(Html.fromHtml(jokeList.get(position).getText().toString()));
        }
    }

    @Override
    public int getItemCount() {
        return jokeList.size();
    }

    static class JokeViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.time)
        TextView time;
        @Bind(R.id.content)
        TextView content;

        public JokeViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
