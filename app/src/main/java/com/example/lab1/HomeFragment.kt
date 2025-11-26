package com.example.lab1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.data.Item
import com.example.lab1.databinding.FragmentHomeBinding
import com.example.lab1.databinding.FragmentMainBinding
import com.example.lab1.databinding.ItemBinding
import java.util.Calendar


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.let { binding ->
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            val itemsLists = listOf(
                Item("Вышел альбом 'бла-бла-бла'", "Сегодня группа 'бла' выпустила альбом 'бла-бла-бла'", "01.01.2022"),
                Item("Пополнение в магазине", "В магазин поступили новые товары", "12.03.2021"),
                Item("Вышел альбом 'абоба'", "Сегодня группа 'баба' выпустила альбом 'абоба'", "01.02.2021"),
                Item("Вышел альбом 'биба'", "Сегодня группа 'боба' выпустила альбом 'биба'", "12.01.2021"),
                Item("Вышел альбом 'боба'", "Сегодня группа 'биба' выпустила альбом 'боба'", "09.01.2021")
            )

            itemAdapter = ItemAdapter(itemsLists)
            binding.recyclerView.adapter=itemAdapter
        }
        Log.d("HOME_LOGGER","Home fragment started at " + Calendar.getInstance().time)
        return binding.root
    }
    }