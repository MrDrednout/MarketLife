package marketlife.window.UsersCreate.sql;

import marketlife.codesoftware.AlertForm;
import marketlife.codesoftware.sql.SQLConnect;

import java.sql.CallableStatement;

import static marketlife.codesoftware.sql.SQLConnect.c;

/**
 * Created by coole on 18.02.2017.
 */
public class UsersCreateSql {

    SQLConnect MS = new SQLConnect();
    AlertForm alertForm = new AlertForm();

    public int executeCreateUser(String f, String i, String o, String logg, String pass, int flg_block) {
        int j = 0;
        try {
            CallableStatement cstmt = c.prepareCall("begin ML.USER_CREATE (?, ?, ?, ?, ?, ?, ?, ?); end;");
            cstmt.setString("F", f);
            cstmt.setString("I", i);
            cstmt.setString("O", o);
            cstmt.setString("LOGG", logg);
            cstmt.setString("PASS", pass);
            cstmt.setInt("FLG_BLOCK", flg_block);
            cstmt.registerOutParameter("WRONG", java.sql.Types.INTEGER);
            cstmt.registerOutParameter("ID_USER", java.sql.Types.INTEGER);
            cstmt.execute();
            if (cstmt.getInt("WRONG") == 1)
                alertForm.alertError("Такой пользователь уже существует", "Придумайте другой логин");
            else
                alertForm.alertInformation("Пользователь успешно создан");
            j = cstmt.getInt("ID_USER");
            cstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

}
