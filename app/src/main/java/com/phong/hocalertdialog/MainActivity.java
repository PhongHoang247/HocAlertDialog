package com.phong.hocalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MoAlertDialog(View view) {
       taoCuaSoAlertDialog();
    }

    public void taoCuaSoAlertDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);/*Đối số trong
        contructors này là đang viết ở cửa sổ nào thì lấy cửa sổ đó .this*/
        //Thiết lập tiêu đề
        builder.setTitle("Xác nhận thoát!");
        //Thiết lập icon
        builder.setIcon(android.R.drawable.ic_dialog_info);//android là thư viện .R để dùng các tài nguyên R của android
        //Thiết lập nội dung cho Dialog
        builder.setMessage("Bạn muốn thoát hả?");
        //Thiết lập các nút lệnh để người dùng tương tác
        builder.setPositiveButton("Có chứ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();//ẩn đi
            }
        });
        //Tạo cửa sổ Dialog
        AlertDialog dialog = builder.create();
        //Nhấn ở ngoài thì ko thoát đc Dialog
        dialog.setCanceledOnTouchOutside(false);
        //Hiển thị cửa sổ Dialog
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        //khi người dùng bấm mũi tên quay lại thì sẽ gọi cửa sổ Alert Dialog
        taoCuaSoAlertDialog();
    }
}
