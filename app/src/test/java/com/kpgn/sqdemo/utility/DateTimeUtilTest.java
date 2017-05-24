package com.kpgn.sqdemo.utility;

import com.kpgn.sqdemo.BuildConfig;
import com.kpgn.sqdemo.application.TestSQDemoApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Date;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class DateTimeUtilTest {

    @Inject
    DateTimeUtil dateTimeUtil;

    @Before
    public void setup() {
        TestSQDemoApplication.inject(this);
    }

    @Test
    public void whenValidDateIsPassed_shouldFormatDateTime() throws Exception {
        Date date = new Date(1495616921903L);
        assertThat(dateTimeUtil.getFormattedDateTime(date)).isNotNull();
        assertThat(dateTimeUtil.getFormattedDateTime(date)).isNotEmpty();
        assertThat(dateTimeUtil.getFormattedDateTime(date)).isEqualTo("May 24, 2017");
    }

    @Test
    public void whenInvalidDateIsPassed_shouldReturnEmptyString() throws Exception {
        assertThat(dateTimeUtil.getFormattedDateTime(null)).isEqualTo("");
    }

}
