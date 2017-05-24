package com.kpgn.sqdemo.activity;

import android.widget.Button;

import com.kpgn.sqdemo.BuildConfig;
import com.kpgn.sqdemo.R;
import com.kpgn.sqdemo.application.TestSQDemoApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.util.ActivityController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    MainActivity mainActivity;
    ActivityController<MainActivity> activityController;

    @Before
    public void setup() {
        TestSQDemoApplication.inject(this);
        mainActivity = new MainActivity();
        activityController = ActivityController.of(Robolectric.getShadowsAdapter(), mainActivity);
        activityController.setup();
    }

    @Test
    public void onCreate_shouldSetTitle() throws Exception {
        assertThat(mainActivity.getTitle()).isEqualTo("SQDemo");
    }

    @Test
    public void onActionUpdateTime_shouldUpdateTime() throws Exception {
        assertThat(mainActivity.message.getText()).isEqualTo("Welcome");
        Button button = (Button) mainActivity.findViewById(R.id.action_update_time);
        button.performClick();
        assertThat(mainActivity.message.getText()).isNotEqualTo("Welcome");
        assertThat(ShadowToast.getTextOfLatestToast()).isEqualTo("Action Done");
    }
}
