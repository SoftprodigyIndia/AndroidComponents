package com.example.firebasedemo

import Artist
import ArtistList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.PhantomReference
import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var databaseReference: DatabaseReference
    lateinit var lists:ArrayList<Artist>
    lateinit var  arrayAdapter: ArtistList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lists=ArrayList<Artist>()
        databaseReference=FirebaseDatabase.getInstance().getReference("artist")
        onClicks()
    }

    override fun onStart() {
        super.onStart()
        databaseReference.addValueEventListener(object:ValueEventListener{


            override fun onDataChange(data: DataSnapshot) {
                //       lists.clear()
                data.children.forEach {
                    val value=it.getValue(Artist::class.java)
                    value?.let {
                        lists.add(it)

                    }
                    arrayAdapter=ArtistList(this@MainActivity,lists)
                    listView.setLayoutManager( LinearLayoutManager(this@MainActivity));

                    listView.adapter=arrayAdapter


                }

            }
            override fun onCancelled(p0: DatabaseError) {

            }


            })

        }


    private fun onClicks() {
        btnAdd.setOnClickListener(this)
    }

    private fun onClick() {
        val spinnerId=spinner.selectedItem.toString()

        if(!TextUtils.isEmpty(edtName.text.toString())){
            val id =databaseReference.push().key
            val artist=Artist(id,edtName.text.toString(),spinnerId)
            id?.let {
                databaseReference.child(it).setValue(artist)
            }
            Toast.makeText(this,"Added",Toast.LENGTH_SHORT).show()


        }else{
            Toast.makeText(this,"Please enter name",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when(v){
            btnAdd->{
                onClick()
            }
        }
    }
}
