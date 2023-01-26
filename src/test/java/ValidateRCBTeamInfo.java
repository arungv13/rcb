import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ForeignPlayers;
import pages.WicketKeepers;
import utils.ReadJSON;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ValidateRCBTeamInfo {
    static ExtentTest test;
    static ExtentReports report;

    DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("dd_MMM_yyyy_HH_mm_ss");
    LocalDateTime now = LocalDateTime.now();

    Path path = Paths.get(System.getProperty("user.dir"), "target");
    String jsonFilePath = path.toString().concat("\\" + "ExtentReportResults_" + currentDate.format(now) + ".html");

    ReadJSON readJSON = new ReadJSON();
    ForeignPlayers foreignPlayers = new ForeignPlayers();
    WicketKeepers wicketKeepers = new WicketKeepers();

    int expectedForeignPlayersCount = 4, expectedWicketKeepersCount = 1;
    int actualForeignPlayersCount = 0, actualWicketKeepersCount = 0;

    @BeforeClass
    public void startTest() {
        report = new ExtentReports(jsonFilePath);
        test = report.startTest("ValidateRCBTeamInfo");
        test.log(LogStatus.INFO, "Before class method is executed");
    }

    @Test
    public void validateTeamDetailsTest() throws Exception {

        actualForeignPlayersCount = foreignPlayers.getForeignPlayersCount(readJSON.fetchJsonData());
        if (actualForeignPlayersCount == expectedForeignPlayersCount)
            test.log(LogStatus.PASS, "Number of foreign players in 'RCB Team' is :'" + actualForeignPlayersCount + "'");
        else
            test.log(LogStatus.FAIL, "Number of foreign players in 'RCB Team' is not :'" + expectedForeignPlayersCount + "'");

        actualWicketKeepersCount = wicketKeepers.getWicketKeepersCount(readJSON.fetchJsonData());
        if (actualWicketKeepersCount >= expectedWicketKeepersCount)
            test.log(LogStatus.PASS, "Number of wicket keepers in 'RCB Team' greater than  or equal to  :'" + expectedWicketKeepersCount + "'");
        else
            test.log(LogStatus.FAIL, "Number of wicket keepers in 'RCB Team' is not greater than or equal to  :'" + actualWicketKeepersCount + "'");
    }

    @AfterClass
    public void endTest() {
        test.log(LogStatus.INFO, "After class method is executed");
        report.endTest(test);
        report.flush();
    }
}