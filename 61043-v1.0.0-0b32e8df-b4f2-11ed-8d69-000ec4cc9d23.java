/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getParameterServlet_executeBatch_15.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: getParameterServlet Read data from a querystring using getParameter
* GoodSource: A hardcoded string
* Sinks: executeBatch
*    GoodSink: prepared sqlstatement, batch
*    BadSink : untrusted input to raw update batch
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import java.util.logging.Logger;

public class CWE89_SQL_Injection__getParameterServlet_executeBatch_15 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                for(int i = 0; i < names.length; ++i)
                {
                    /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                    sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            try
            {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("update users set hitcount=hitcount+1 where name=?");
                for(int i = 0; i < names.length; ++i)
                {
                    sqlstatement.setString(1, names[i]);
                    sqlstatement.addBatch();
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        break;
        default:
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                for(int i = 0; i < names.length; ++i)
                {
                    /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                    sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            try
            {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("update users set hitcount=hitcount+1 where name=?");
                for(int i = 0; i < names.length; ++i)
                {
                    sqlstatement.setString(1, names[i]);
                    sqlstatement.addBatch();
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                for(int i = 0; i < names.length; ++i)
                {
                    /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                    sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            try
            {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("update users set hitcount=hitcount+1 where name=?");
                for(int i = 0; i < names.length; ++i)
                {
                    sqlstatement.setString(1, names[i]);
                    sqlstatement.addBatch();
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                for(int i = 0; i < names.length; ++i)
                {
                    /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                    sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        break;
        default:
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            try
            {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("update users set hitcount=hitcount+1 where name=?");
                for(int i = 0; i < names.length; ++i)
                {
                    sqlstatement.setString(1, names[i]);
                    sqlstatement.addBatch();
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            try
            {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("update users set hitcount=hitcount+1 where name=?");
                for(int i = 0; i < names.length; ++i)
                {
                    sqlstatement.setString(1, names[i]);
                    sqlstatement.addBatch();
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String names[] = data.split("-");
            int iSuccess = 0;
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                for(int i = 0; i < names.length; ++i)
                {
                    /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                    sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                }
                int dbResults[] = sqlstatement.executeBatch();
                for( int i = 0; i < names.length; ++i )
                {
                    if( dbResults[i] > 0 )
                    {
                        iSuccess++;
                    }
                }
                IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        break;
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
