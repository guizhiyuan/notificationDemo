package contentprovider.guizhiyuan.com.NotificationTest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import contentprovider.guizhiyuan.com.contentprovider.R;

public class MainActivity extends AppCompatActivity {
    private Button mShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShow = (Button) findViewById(R.id.send_notice);
        mShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Notification
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                /**
                 * 设置相应的属性
                 */
                //设置小图标
                builder.setSmallIcon(R.mipmap.ic_launcher);
                //设置可返回
                builder.setAutoCancel(true);
                //设置大图标
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                //设置标题
                builder.setContentTitle("I am title!");
                //设置内容
                builder.setContentText("This is my first notification test!");
                builder.setSubText("Having a upgrade!");
                //构造pendingIntent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                PendingIntent pendingIntent = PendingIntent.getActivities(MainActivity.this, 0, new Intent[]{intent}, 0);
                //设置跳转
                builder.setContentIntent(pendingIntent);
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
            }
        });
    }
}
