package course.labs.permissionslab;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Browser;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BookmarksActivity extends Activity {
	
	private static final String TAG = "Lab-Permissions";

	static final String[] projection = { Browser.BookmarkColumns.TITLE,
			Browser.BookmarkColumns.URL };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookmarks_activity);

		

	}

	private void loadBookmarks() {

		Log.i(TAG, "Entered loadBookmarks()");

		String text = "";

		Cursor query = getContentResolver().query(Browser.BOOKMARKS_URI,
				projection, null, null, null);

		query.moveToFirst();
		while (query.moveToNext()) {

			text += query.getString(query
					.getColumnIndex(Browser.BookmarkColumns.TITLE));
			text += "\n";
			text += query.getString(query
					.getColumnIndex(Browser.BookmarkColumns.URL));
			text += "\n\n";

		}

		TextView box = (TextView) findViewById(R.id.text);
		box.setText(text);

		Log.i(TAG, "Bookmarks loaded");
	}

	private void startGoToDangerousActivity() {

		Log.i(TAG, "Entered startGoToDangerousActivity()");
        Intent i = new Intent(this, GoToDangerousActivity.class);
        startActivity(i);
		// TODO - Start the GoToDangerousActivity
		

	}

}
