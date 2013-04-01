package iracing.webapi;

/**
 *
 * @author Christian Aylward
 * @version 1.0.0
 */
public class Iracing {
    
    public enum UriAbsolutePathType {
        LOGIN,
        LOGIN_FORM_TARGET,
        FAILED_LOGIN,
        HOME,
        SERVER_UPDATE,
        ACTIVITY_SUMMARY,
        ROLODEX
    }
    
    private static String URL_MEMBERS_HOMEPAGE_BASE = "http://members.iracing.com";
    private static String URL_MEMBERS_HOMEPAGE_BASE_SECURE = "https://members.iracing.com";
    private static String URI_ABSOLUTE_PATH_LOGIN = "/membersite/login.jsp";
    private static String URI_ABSOLUTE_PATH_LOGIN_TARGET = "/membersite/Login";
    private static String URI_ABSOLUTE_PATH_FAILED_LOGIN = "/membersite/failedlogin.jsp";
    private static String URI_ABSOLUTE_PATH_HOME = "/membersite/member/Home.do";
    private static String URI_ABSOLUTE_PATH_STATS = "/membersite/member/results.jsp";
    private static String URI_ABSOLUTE_PATH_EVENT_RESULTS = "/membersite/member/EventResult.do";
    private static String URI_ABSOLUTE_PATH_ACTIVITY_SUMMARY = "/membersite/member/GetResults";
    private static String URI_ABSOLUTE_PATH_LAPTIMES = "/membersite/member/GetLaps";
    private static String URI_ABSOLUTE_PATH_ROLODEX = "/membersite/member/Rolodex.do";
    private static String URI_ABSOLUTE_PATH_SERVER_UPDATE = "/updating/maintenanceupdate.htm";
    
    public static String getUrl(UriAbsolutePathType type) {
        if (type == UriAbsolutePathType.LOGIN) {
            return URL_MEMBERS_HOMEPAGE_BASE_SECURE + URI_ABSOLUTE_PATH_LOGIN;
        } else if (type == UriAbsolutePathType.LOGIN_FORM_TARGET) {
            return URL_MEMBERS_HOMEPAGE_BASE_SECURE + URI_ABSOLUTE_PATH_LOGIN_TARGET;
        } else if (type == UriAbsolutePathType.HOME) {
            return URL_MEMBERS_HOMEPAGE_BASE + URI_ABSOLUTE_PATH_HOME;
        } else if (type == UriAbsolutePathType.ACTIVITY_SUMMARY) {
            return URL_MEMBERS_HOMEPAGE_BASE + URI_ABSOLUTE_PATH_ACTIVITY_SUMMARY;
        } else if (type == UriAbsolutePathType.ROLODEX) {
            return URL_MEMBERS_HOMEPAGE_BASE + URI_ABSOLUTE_PATH_ROLODEX;
        } else {
            return null;
        }
    }

    public static String getUriAbsolutePath(UriAbsolutePathType type) {
        if (type == UriAbsolutePathType.LOGIN) {
            return URI_ABSOLUTE_PATH_LOGIN;
        } else if (type == UriAbsolutePathType.LOGIN_FORM_TARGET) {
            return URI_ABSOLUTE_PATH_LOGIN_TARGET;
        } else if (type == UriAbsolutePathType.HOME) {
            return URI_ABSOLUTE_PATH_HOME;
        } else if (type == UriAbsolutePathType.FAILED_LOGIN) {
            return URI_ABSOLUTE_PATH_FAILED_LOGIN;
        } else if (type == UriAbsolutePathType.SERVER_UPDATE) {
            return URI_ABSOLUTE_PATH_SERVER_UPDATE;
        } else if (type == UriAbsolutePathType.ACTIVITY_SUMMARY) {
            return URI_ABSOLUTE_PATH_ACTIVITY_SUMMARY;
        } else if (type == UriAbsolutePathType.ROLODEX) {
            return URI_ABSOLUTE_PATH_ROLODEX;
        } else {
            return null;
        }
    }
    
}