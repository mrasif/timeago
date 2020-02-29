package dev.mrasif.lib.timeago;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class TimeAgoTest {

    SimpleDateFormat format;

    @Before
    public void setUp() throws Exception {
        format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    }

    @Test
    public void format_with_null_value_parameters() {
        String status=TimeAgo.format(null);
        assertNull(status);
    }

    @Test
    public void format_with_1_year_gap() throws Exception{
        Date past = format.parse("28/01/2019 17:23:46");
        Date now = format.parse("28/01/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("a year ago",is(status));
    }

    @Test
    public void format_with_2_years_gap() throws Exception{
        Date past = format.parse("28/01/2018 17:23:46");
        Date now = format.parse("28/01/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("2 years ago",is(status));
    }

    @Test
    public void format_with_1_month_gap() throws Exception{
        Date past = format.parse("28/01/2020 17:23:46");
        Date now = format.parse("28/02/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("a month ago",is(status));
    }

    @Test
    public void format_with_2_months_gap() throws Exception{
        Date past = format.parse("28/01/2020 17:23:46");
        Date now = format.parse("28/03/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("2 months ago",is(status));
    }

    @Test
    public void format_with_1_day_gap() throws Exception{
        Date past = format.parse("28/02/2020 17:23:46");
        Date now = format.parse("29/02/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("yesterday",is(status));
    }

    @Test
    public void format_with_3_day_gap() throws Exception{
        Date past = format.parse("26/02/2020 17:23:46");
        Date now = format.parse("29/02/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("3 days ago",is(status));
    }

    @Test
    public void format_with_1_hour_gap() throws Exception{
        Date past = format.parse("29/02/2020 16:23:46");
        Date now = format.parse("29/02/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("an hour ago",is(status));
    }

    @Test
    public void format_with_2_hour_gap() throws Exception{
        Date past = format.parse("29/02/2020 15:23:46");
        Date now = format.parse("29/02/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("2 hours ago",is(status));
    }

    @Test
    public void format_with_1_minute_gap() throws Exception{
        Date past = format.parse("29/02/2020 17:22:46");
        Date now = format.parse("29/02/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("a minute ago",is(status));
    }

    @Test
    public void format_with_2_minutes_gap() throws Exception{
        Date past = format.parse("29/02/2020 17:21:46");
        Date now = format.parse("29/02/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("2 minutes ago",is(status));
    }

    @Test
    public void format_with_1_second_gap() throws Exception{
        Date past = format.parse("29/02/2020 17:23:45");
        Date now = format.parse("29/02/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("a second ago",is(status));
    }

    @Test
    public void format_with_2_seconds_gap() throws Exception{
        Date past = format.parse("29/02/2020 17:23:44");
        Date now = format.parse("29/02/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("2 seconds ago",is(status));
    }

    @Test
    public void format_with_moment_gap() throws Exception{
        Date past = format.parse("29/02/2020 17:23:46");
        Date now = format.parse("29/02/2020 17:23:46");
        String status=TimeAgo.format(past,now);
        assertThat("a moment ago",is(status));
    }

    @Test
    public void format_with_only_past_date_param() throws Exception{
        Date past = format.parse("29/02/2019 17:23:46");
        String status=TimeAgo.format(past);
        assertNotNull(status);
    }

    @Test
    public void format_date_parse_test() throws Exception{
        String status=TimeAgo.format("dd/MM/yyyy hh:mm:ss","29/02/2020 17:23:44","29/02/2020 17:23:46");
        assertThat("2 seconds ago",is(status));
    }

    @Test(expected = ParseException.class)
    public void format_date_parse_test_with_invalid_format() throws Exception{
        String status=TimeAgo.format("dd/MM/yyyy-hh:mm:ss","29/02/2020 17:23:44","29/02/2020 17:23:46");
        assertThat("2 seconds ago",is(status));
    }

    @Test
    public void format_date_only_past_parse_test() throws Exception{
        String status=TimeAgo.format("dd/MM/yyyy hh:mm:ss","29/02/2020 17:23:44");
        assertNotNull(status);
    }

    @Test(expected = ParseException.class)
    public void format_date_only_past_parse_test_with_invalid_format() throws Exception{
        String status=TimeAgo.format("dd/MM/yyyy-hh:mm:ss","29/02/2020 17:23:44");
        assertNotNull(status);
    }

    @After
    public void tearDown() throws Exception {
        format=null;
    }
}
