package kr.hs.emirim.w2034.mom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    ImageButton btn_nologin, btn_naver, btn_kakao, btn_google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_nologin = findViewById(R.id.btn_nologin);
        btn_nologin.setOnClickListener(btnListener);
        btn_naver = findViewById(R.id.btn_naver);
        btn_kakao = findViewById(R.id.btn_kakao);
        btn_google = findViewById(R.id.btn_google);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_nologin:
                    new AlertDialog.Builder(LoginActivity.this)
                            .setMessage("비회원 로그인 시 즐겨찾기 \n" +
                                    "기능을 사용할 수 없습니다.\n\n로그인은 마이페이지에서 \n" +
                                    "언제나 하실 수 있습니다.")
                            .setPositiveButton("확인", btnPositiveListener)
                            .show();

            }
        }
    };

    DialogInterface.OnClickListener btnPositiveListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(LoginActivity.this, "비회원으로 시작되었습니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };
}