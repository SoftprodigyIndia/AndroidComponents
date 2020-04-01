package com.example.firebasedemo

import Artist
import ArtistList
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.show_dialog.*
import java.lang.ref.PhantomReference
import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var databaseReference: DatabaseReference
    lateinit var updateReference: DatabaseReference

    lateinit var lists:ArrayList<Artist>
    lateinit var  arrayAdapter: ArtistList
    lateinit var   editNames:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lists=ArrayList<Artist>()
        databaseReference=FirebaseDatabase.getInstance().getReference("artist")
        onClicks()
    }

    override fun onStart() {
        super.onStart()
        databaseReference.addValueEventListener(object:ValueEventListener,
            ArtistList.OnUpdateclick {


            override fun onDataChange(data: DataSnapshot) {
                //       lists.clear()
                lists.clear()
              for(h in data.children) {
                  val hero=h.getValue(Artist::class.java)
                  hero?.let {
                      lists.add(it)
                  }


                    arrayAdapter=ArtistList(this@MainActivity,lists,this)
                    listView.setLayoutManager( LinearLayoutManager(this@MainActivity));

                    listView.adapter=arrayAdapter


                }

            }
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onUpdate(artist: Artist) {
                val id =databaseReference.push().key
            var  spinnern:Spinner?=null

                val alert = AlertDialog.Builder(this@MainActivity)
                val inflater = LayoutInflater.from(this@MainActivity)
                val view = inflater.inflate(R.layout.show_dialog, null)
                editNames = view.findViewById<EditText>(R.id.edtSpin)
                spinnern= view.findViewById<Spinner>(R.id.spinners)
                val spinners=spinnern.selectedItem.toString()


                editNames.setText(artist.artistName)
                alert.setView(view)
                alert.setPositiveButton("Update",object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {

                        updateReference=FirebaseDatabase.getInstance().getReference("artist")
                            if(!edtName.text.isNullOrEmpty()){
                                val heros=Artist(artist.artistId,editNames.text.toString(),spinners)

                                updateReference.child(artist.artistId.toString()).setValue(heros)

                        }
                    }

                })


              alert.setNegativeButton("Negative",object :DialogInterface.OnClickListener{
                  override fun onClick(dialog: DialogInterface?, which: Int) {
                      TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                  }

              })

                    alert.show()
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
