package com.example.simpletodo

import android.R
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.simpletodo.ui.theme.SimpleTodoTheme


class MainActivity : Activity() {
    private var items: ArrayList<String>? = null
    private var itemsAdapter: ArrayAdapter<String>? = null
    private var lvItems: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ADD HERE
        lvItems = findViewById<View>(R.id.lvItems) as ListView
        items = ArrayList()
        itemsAdapter = ArrayAdapter(
            this,
            R.layout.simple_list_item_1, items!!
        )
        lvItems!!.adapter = itemsAdapter
        items!!.add("First Item")
        items!!.add("Second Item")

        fun onAddItem(v: View) {
            val etNewItem = findViewById<EditText>(R.id.etNewItem)
            val itemText = etNewItem.text.toString()
            itemsAdapter?.add(itemText)
            etNewItem.setText("")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleTodoTheme {
        Greeting("Android")
    }
}