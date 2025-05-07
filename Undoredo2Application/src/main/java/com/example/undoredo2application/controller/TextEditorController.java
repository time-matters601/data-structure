package com.example.undoredo2application.controller;


import ch.qos.logback.core.model.Model;
import com.example.undoredo2application.Service.TextEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TextEditorController {

    @Autowired
    private TextEditor textEditor;

    @GetMapping("/")
    public String index(Model model) {
        model.addText("currentText");
        model.addText("canUndo");
        model.addText("canRedo");
        return "editor";

        }

        // REST API endpoint for AJAX CALLS
    @PostMapping("/api/update")
    @ResponseBody
    public Map<String, Object> undo() {
        textEditor.undo();
        return getEditorState();

    }

    @PostMapping("/api/state")
    @ResponseBody
    public Map<String, Object> redo() {
        return getEditorState();
    }

    //helper method to create response with editor state
    private Map<String, Object> getEditorState() {
        Map<String, Object> state = new HashMap<>();
        state.put("currentText", textEditor.getCurrentText());
        state.put("canUndo", textEditor.canUndo());
        state.put("canRedo", textEditor.canRedo());

        return state;

    }


}
