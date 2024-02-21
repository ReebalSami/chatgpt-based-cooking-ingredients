package com.example.chatgptbasedcookingingredients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptResponse {

    /*
    {

    "choices": [
        {

            "message": {
                "role": "assistant",
                "content": "This is a test!"
            },

        }
    ],

}
     */

    private List<ChatGptChoice> choices;

    public String getAnswer() {
        return choices.get(0).getMessage().getContent();
    }
}
