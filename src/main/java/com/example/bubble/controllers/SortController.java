package com.example.bubble.controllers;

import com.example.bubble.models.Bubble;
import com.example.bubble.models.Element;
import com.example.bubble.repo.BubbleRepository;
import com.example.bubble.repo.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class SortController {
    @Autowired
    private BubbleRepository bubbleRepository;
    @Autowired
    private ElementRepository elementRepository;
    private void bubbleSort(int[] array){
        for (int i=0;i< array.length;i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
            }
        }
    }
    @PostMapping("/sort")
    public String sortBubble(@RequestParam String number, Model model){

        String[] strings = number.split(" ");
        int n = strings.length;
        int[] array = new int[n];

        for (int i=0;i< strings.length;i++) {
            array[i] = Integer.parseInt(strings[i]);
        }

        bubbleSort(array);

        String s="";
        for(int i=0;i< array.length;i++){
            s=s+Integer.toString(array[i])+" ";
        }
        Bubble bubble = new Bubble(s);

        for(int i=0;i< array.length;i++){
            Element element =new Element(array[i],bubble);
            elementRepository.save(element);
        }
        model.addAttribute("result", s);
        bubbleRepository.save(bubble);

        return "home";
    }

    @GetMapping("/print/{id}")
    public String blogMain(@PathVariable(value = "id") long id, Model model){
        Optional<Bubble> bubbles =bubbleRepository.findAllById(id);
        ArrayList<Bubble> res= new ArrayList<>();
        bubbles.ifPresent(res::add);
        model.addAttribute("bubbles", res);
        return "bubble";
    }
}
