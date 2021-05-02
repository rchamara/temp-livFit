package com.example.LivFit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.LivFit.Entity.User;
import com.example.LivFit.Utility.Constant;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * ???? Do not use this class as model ????
 */
public class Register extends AppCompatActivity {

    private Button mContinue;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mUserName;

    private FirebaseDatabase mFireStoreDatabase;
    private DatabaseReference mFireStoreDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContinue = (Button) findViewById(R.id.btContinue);
        mFirstName = (EditText) findViewById(R.id.ptEnterFName2);
        mLastName = (EditText) findViewById(R.id.ptEnterLName);
        mUserName = (EditText) findViewById(R.id.ptEnterUserName);
        initFireStoreDatabase();
        setContinueOnClickHandler();

        /**
         * just for test
         */
        getUserData();
    }

    /**
     * init the fire base data base reference when ever the activity is
     * started
     * check weather device is online if not show error message to the user
     */
    private void initFireStoreDatabase () {
        /**
         * TODO ???
         * check when FirebaseApp.initializeApp(this); is needed. i can not remember :D
         * check in firebase api doc
         */

        // TODO?? check weather device is online
        try {
            mFireStoreDatabase = FirebaseDatabase.getInstance();
        } catch (Exception exc) {
            // TODO log error here
            exc.printStackTrace();
        }
    }

    /**
     * Overload method for if user has DOC path
     * @param path doc path for fire store data base
     */
    private void getDatabaseRefByPath (String path) {
        try {
             mFireStoreDatabaseRef = FirebaseDatabase.getInstance().getReference(path);
        } catch (Exception exc) {
            // TODO ?? log here
        }
    }

    /**
     * Overload method for if user has not DOC path
     */
    private void getDatabaseRefByPath () {
        try {
            mFireStoreDatabaseRef = FirebaseDatabase.getInstance().getReference();
        } catch (Exception exc) {
            // TODO ?? log here
        }
    }

    /**
     * set on click listener in continu button
     */
    private void setContinueOnClickHandler () {
        try {
            mContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // write to the fire store
                    saveDataToFireStore();
                }
            });
        } catch (NullPointerException exc) {
            // TODO ?? log here
        }
    }

    /**
     * validate all input field before proceed
     * the save in the fire store
     */
    private boolean validateInput () {
        // .... logic go here
        return true;
    }

    /**
     * this method handle all when data write into the data base
     */
    private void saveDataToFireStore () {
        try {
            if (validateInput()) {
                User user = new User(
                        mFirstName.getText().toString(),
                        mLastName.getText().toString(),
                        mUserName.getText().toString());
                /**
                 * this code user for write something into fire store
                 */
                getDatabaseRefByPath();
                mFireStoreDatabaseRef
                        .child(Constant.FIRE_BASE_USER_DOC_PATH)
                        .child(Constant.USER_ID)
                        .setValue(user);
            } else {
                // TODO ?? show something to user
            }
        } catch (Exception exc) {
            // TODO ?? log here and rollback
        }
    }

    /**
     * get user data from fire store
     */
    private void getUserData () {
        getDatabaseRefByPath(Constant.FIRE_BASE_USER_DOC_PATH+"/"+Constant.USER_ID);
        mFireStoreDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                /**
                 * do what ever do you want this user object
                 */
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}