package lab4.ui_tests.lab4_ui_test_navigation_task5

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import lab4.ui_tests.lab4_ui_test_navigation_task5.databinding.Fragment2Binding

class Fragment2: Fragment(){
    private lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment2Binding.inflate(layoutInflater)
        val navController = findNavController()
        binding.bnToThird.setOnClickListener {
            navController.navigate(R.id.action_fragment2_to_fragment3)
        }
        binding.bnToFirst.setOnClickListener {
            navController.navigate(R.id.action_fragment2_to_fragment1)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about) {
            Navigation.findNavController(binding.root).navigate(R.id.about)
            true
        } else
            super.onOptionsItemSelected(item)
    }
}