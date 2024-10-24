package com.example.springdatarestissue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.springdatarestissue.entity.Author;
import com.example.springdatarestissue.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ContextConfiguration(classes = {SpringBootMain.class})
@WebAppConfiguration
class SpringDataRestTest
{

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private AuthorRepository authorRepository;

  @Test
  public void testPostBook() throws Exception {
    Author author = new Author();
    author.setName("Ernest Hemingway");
    author = authorRepository.saveAndFlush(author);

    String requestJson = String.format(
      """
      {
        "title": "The Old Man and the Sea",
        "author": "/authors/%d"
      }
      """, author.getId());

    MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    mockMvc.perform(post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestJson)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

}
