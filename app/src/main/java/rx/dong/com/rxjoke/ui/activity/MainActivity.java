package rx.dong.com.rxjoke.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.dong.com.rxjoke.R;
import rx.dong.com.rxjoke.common.AutoLoadRecylerView;
import rx.dong.com.rxjoke.common.AutoLoadRecylerView.loadMoreListener;
import rx.dong.com.rxjoke.common.DividerItemDecoration;
import rx.dong.com.rxjoke.model.ContentlistEntity;
import rx.dong.com.rxjoke.presenter.JokePresenter;
import rx.dong.com.rxjoke.ui.BaseActivity;
import rx.dong.com.rxjoke.ui.adapter.JokeAdapter;
import rx.dong.com.rxjoke.ui.view.JokeView;

/**
 * Created by JDD on 2016/4/8.
 */
public class MainActivity extends BaseActivity implements JokeView,
        SwipeRefreshLayout.OnRefreshListener, loadMoreListener {

    @Bind(R.id.record_recycleview)
    AutoLoadRecylerView recordRecycleview;
    @Bind(R.id.common_error_txt)
    TextView commonErrorTxt;
    @Bind(R.id.retry_btn)
    Button retryBtn;
    @Bind(R.id.common_error)
    RelativeLayout commonError;
    @Bind(R.id.joke_refresh_layout)
    SwipeRefreshLayout jokeRefreshLayout;
    @Bind(R.id.mWebView)
    WebView mWebView;
    @Bind(R.id.mScrollView)
    ScrollView mScrollView;
    private JokePresenter jokePresenter;
    private LinearLayoutManager layoutManager;
    private int page = 1;
    private List<ContentlistEntity> jokeList;
    private JokeAdapter jokeAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r5activity_main);
        ButterKnife.bind(this);
        Pig pig1= new Pig("dd");
        Pig pig2= new Pig("dd");
        Pig.dd=-1;
        Pig pig3= new Pig("dd");
        Pig pig4= new Pig("dd");
        Toast.makeText(getApplicationContext(),Pig.dd+"",Toast.LENGTH_LONG).show();;
        initView();
        initData();
        loadData();


    }

    private void initView() {
        jokeRefreshLayout.setOnRefreshListener(this);
        layoutManager = new LinearLayoutManager(this);
        recordRecycleview.setLayoutManager(layoutManager);
        recordRecycleview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration
                .VERTICAL_LIST));
        recordRecycleview.setLoadMoreListener(this);
//        mWebView.getSettings().setDefaultTextEncodingName("UTF-8");//设置默认为utf-8
//
//        String htmlString = "  <div class=\"H-overflow-scrolling H-margin-10 H-position-relative\">\n" +
//                "        <table class=\"H-table H-table-fixed H-theme-background-color-white H-border-vertical-top-after H-border-horizontal-left-after\">\n" +
//                "            <thead>\n" +
//                "                <tr>\n" +
//                "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">流水号</th>\n" +
//                "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">产品名称</th>\n" +
//                "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">销售价格</th>\n" +
//                "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">生产日期</th>\n" +
//                "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">保质期</th>\n" +
//                "                    <th class=\"H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after\">生产商</th>\n" +
//                "                </tr>\n" +
//                "            </thead>\n" +
//                "            <tbody>\n" +
//                "                <tr>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">000000012</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">300ML 可口可乐</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">￥3.50</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2016-05-15</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2018-05-15</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">中山赢友网络科技有限公司</td>\n" +
//                "                </tr>\n" +
//                "                <tr>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">000000012</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">300ML 可口可乐</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">￥3.50</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2016-05-15</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2018-05-15</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">中山赢友网络科技有限公司</td>\n" +
//                "                </tr>\n" +
//                "                <tr>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">000000012</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">300ML 可口可乐</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">￥3.50</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2016-05-15</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2018-05-15</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">中山赢友网络科技有限公司</td>\n" +
//                "                </tr>\n" +
//                "                <tr>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">000000012</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">300ML 可口可乐</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">￥3.50</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2016-05-15</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2018-05-15</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">中山赢友网络科技有限公司</td>\n" +
//                "                </tr>\n" +
//                "                <tr>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">000000012</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">300ML 可口可乐</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">￥3.50</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2016-05-15</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">2018-05-15</td>\n" +
//                "                    <td class=\"H-padding-10 H-vertical-align-middle H-font-size-14 H-border-vertical-bottom-after H-border-horizontal-right-after\">中山赢友网络科技有限公司</td>\n" +
//                "                </tr>\n" +
//                "            </tbody>\n" +
//                "        </table>\n" +
//                "    </div>";
//        mWebView.loadData(htmlString, "text/html; charset=UTF-8", null);


        mWebView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                    mScrollView.requestDisallowInterceptTouchEvent(false);
                else
                    mScrollView.requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

    }

    private void initData() {
        jokeList = new ArrayList<>();
        jokeAdapter = new JokeAdapter(jokeList);
        recordRecycleview.setAdapter(jokeAdapter);

        jokePresenter = new JokePresenter();
        jokePresenter.attachView(this);
    }

    private void loadData() {
        jokePresenter.loadList(page);
        page++;
    }

    @Override
    public void onRefresh() {
        page = 1;
        loadData();
    }


    @Override
    public void onLoadMore() {
        loadData();
    }

    /**
     * @param data 回调 以下三个方法是presenter回调的函数 用于更新界面
     */
    @Override
    public void refresh(List<ContentlistEntity> data) {
        commonError.setVisibility(View.GONE);
        jokeList.clear();
        jokeList.addAll(data);
        jokeAdapter.notifyDataSetChanged();
        jokeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMore(List<ContentlistEntity> data) {
        commonError.setVisibility(View.GONE);
        jokeList.addAll(data);
        jokeAdapter.notifyDataSetChanged();
        recordRecycleview.setLoading(false);
    }

    @Override
    public void showError(String msg, View.OnClickListener onClickListener) {
        super.showError(msg, onClickListener);
        commonError.setVisibility(View.VISIBLE);
        recordRecycleview.setLoading(false);
        jokeRefreshLayout.setRefreshing(false);
    }

    @OnClick(R.id.retry_btn)
    void setRetryBtnonClick() {
        onRefresh();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        jokePresenter.detachView();
    }
}
