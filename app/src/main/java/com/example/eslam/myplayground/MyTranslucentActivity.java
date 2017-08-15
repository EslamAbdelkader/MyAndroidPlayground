package com.example.eslam.myplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyTranslucentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_translucent);

        VfgTcLandingModel model = getIntent().getExtras().getParcelable(TermsAndConditionsManager.LANDING_PAGE_INTENT_MODEL);
        populateData(model);
    }

    private void createClickableFooter(String text, String privacyText, String termsText) {
        ClickableSpan privacyClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                //TODO Navigate to Privacy Screen instead of toast
                Toast.makeText(MyTranslucentActivity.this, "Privacy", Toast.LENGTH_SHORT).show();
            }
        };
        ClickableSpan termsClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                //TODO Navigate to T&C details Screen instead of toast
                Toast.makeText(MyTranslucentActivity.this, "Terms", Toast.LENGTH_SHORT).show();
            }
        };
        SpannableString spannableString = new SpannableString(text);
        if (text.contains(privacyText)) {
            int privacyStart = text.indexOf(privacyText);
            int privacyEnd = privacyStart + privacyText.length();
            spannableString.setSpan(privacyClickableSpan, privacyStart, privacyEnd, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (text.contains(termsText)) {
            int termsStart = text.indexOf(termsText);
            int termsEnd = termsStart + termsText.length();
            spannableString.setSpan(termsClickableSpan, termsStart, termsEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        TextView footer = (TextView) findViewById(R.id.footer);
        footer.setText(spannableString);
        footer.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void populateData(VfgTcLandingModel model) {
        String title, header, description, buttonText, footerText, privacyText, termsText;
        if(model!=null) {
            title = model.getTitle();
            header = model.getHeader();
            description = model.getDescription();
            buttonText = model.getButtonText();
            footerText = model.getFooter();
            privacyText = model.getPrivacyText();
        }else{
            title = getResources().getString(R.string.vfg_tc_landing_page_title);
        }

        setPageTitle(title);
        setHeader(model.getHeader());
        setDescription(model.getDescription());
        setButtonText(model.getButtonText());
        createPermissions(model.getPermissionItems());
        createClickableFooter(model.getFooter(), model.getPrivacyText(), model.getTermsText());
    }

    private void createPermissions(List<VfgTcLandingModel.PermissionItem> permissionItems) {
        if (permissionItems != null) {
            LinearLayout permissionsLayout = (LinearLayout) findViewById(R.id.permissionsLayout);
            for (VfgTcLandingModel.PermissionItem item : permissionItems) {
                permissionsLayout.addView(new PermissionLayout(getApplicationContext(), item));
            }
        }
    }

    private void setButtonText(String buttonText) {
        if (!TextUtils.isEmpty(buttonText)) {
            TextView headerTextView = (TextView) findViewById(R.id.button);
            headerTextView.setText(buttonText);
        }
    }

    private void setDescription(String description) {
        if (!TextUtils.isEmpty(description)) {
            TextView headerTextView = (TextView) findViewById(R.id.description);
            headerTextView.setText(description);
        }
    }

    private void setHeader(String header) {
        if (!TextUtils.isEmpty(header)) {
            TextView headerTextView = (TextView) findViewById(R.id.header);
            headerTextView.setText(header);
        }
    }

    private void setPageTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            TextView titleTextView = (TextView) findViewById(R.id.title);
            titleTextView.setText(title);
        }
    }


}
