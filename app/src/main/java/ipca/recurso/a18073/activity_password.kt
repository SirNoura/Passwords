package ipca.recurso.a18073

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class activity_password : AppCompatActivity() {
    private val newPassActivityRequestCode = 1
    private lateinit var passViewModel: PassViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = PassListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        passViewModel = ViewModelProvider(this).get(PassViewModel::class.java)

        passViewModel.allPassw.observe(this, Observer { pass ->
            // Update the cached copy of the words in the adapter.
            pass?.let { adapter.setWords(it) }
        })
        val fab = findViewById<FloatingActionButton>(R.id.plus)
        fab.setOnClickListener {
            val intent = Intent(this, NewPasswordActivity::class.java)
            startActivityForResult(intent, newPassActivityRequestCode)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newPassActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewPasswordActivity.EXTRA_REPLY)?.let {
                val pass = managePassword(it)
                passViewModel.insert(pass)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }
}