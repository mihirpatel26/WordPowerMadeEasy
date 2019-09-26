package Config;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "wordDB";


    //table name
    private static final String WORD_MASTER = "word";
    private static final String SESSION_MASTER = "session";
    private static final String WORD_SESSION_MASTER = "word_session";
    private static final String USER_SESSION = "current_session";

    //WORD table name
    private static final String KEY_WORD_ID = "id";
    private static final String KEY_WORD_NAME = "name";
    private static final String KEY_WORD_ROOT = "root";
    private static final String KEY_WORD_MEANING = "meaning";
    private static final String KEY_WORD_EXAMPLE = "example";
    private static final String KEY_WORD_SID = "s_id";

    //SESSION table name
    private static final String KEY_SESSION_ID = "id";
    private static final String KEY_SESSION_NUMBER = "name";
    private static final String KEY_SESSION_DESCRIPTION = "desc";

    //WORD_SESSION table name
    private static final String KEY_WORD_SESSION_ID = "id";
    private static final String KEY_WORD_SESSION_WID = "w_id";
    private static final String KEY_WORD_SESSION_SID = "s_id";

    //USER_SESSION table name
    private static final String KEY_USER_SESSION_NUMBER = "number";

    Context cntxt = null;

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        cntxt = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {

    }



    public ArrayList<String> GetWordList(){
        ArrayList<String> WordList = new ArrayList<String>();
        SQLiteDatabase mySelectDb = null;
        try{
            mySelectDb = this.getWritableDatabase();
            String selectQuery = "SELECT word.id, word.name, word.root, word.meaning, word.example" +
                    "FROM word";

            Cursor cursor = mySelectDb.rawQuery(selectQuery, null);
            if (cursor.getCount() > 0){
                if (cursor.moveToFirst()){
                    for (int i = 0; i < cursor.getCount(); i++){
                        String word_id = cursor.getString(0);
                        String word_name = cursor.getString(1);
                        String word_root = cursor.getString(2);
                        String word_meaning = cursor.getString(3);
                        String word_example = cursor.getString(4);
                        WordList.add(word_id + "#" + word_name + "#" + word_root + "#" + word_meaning + "#" + word_example);
                        cursor.moveToNext();

                    }
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return WordList;
    }

    public boolean IsTabExist(SQLiteDatabase mDatabase, String TableName) {
        boolean IsExist = false;
        try {
            Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TableName,
                    null);

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    cursor.close();
                    IsExist = true;
                }
                cursor.close();
            }
            return IsExist;
        } catch (Exception err) {
            //CommonClass.writelog("DatabaseHandler:IsTabExist", "Exception" + err.getMessage()
                    //+ ":::StactTrace:" + err.getStackTrace().toString());
            return IsExist;
        }
    }

    













}
