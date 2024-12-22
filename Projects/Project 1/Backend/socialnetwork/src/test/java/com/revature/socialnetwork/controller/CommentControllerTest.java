//package com.revature.socialnetwork.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.socialnetwork.entity.Comment;
//import com.revature.socialnetwork.entity.Post;
//import com.revature.socialnetwork.entity.User;
//import com.revature.socialnetwork.service.CommentService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(CommentController.class)
//public class CommentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private CommentService commentService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testAddComment() throws Exception {
//        Comment comment = new Comment();
//        Post post = new Post();
//        User user = new User();
//        post.setId(1);
//        user.setId(1);
//        post.setUser(user);
//        comment.setContent("Test comment content");
//        comment.setPostId(post); // Set postId
//        comment.setUserId(user); // Set userId
//
//        when(commentService.addComment(any(Comment.class))).thenReturn(comment);
//
//        mockMvc.perform(post("/api/comments")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(comment)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value("Test comment content"))
//                .andExpect(jsonPath("$.postId").value(1)) // Verify postId
//                .andExpect(jsonPath("$.userId").value(1)); // Verify userId
//    }
//
//    @Test
//    void testGetAllComments() throws Exception {
//        List<Comment> comments = List.of(new Comment(), new Comment());
//
//        when(commentService.getAllComments()).thenReturn(comments);
//
//        mockMvc.perform(get("/api/comments")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0]").exists())
//                .andExpect(jsonPath("$[1]").exists());
//    }
//
//    @Test
//    void testGetCommentsByPostId() throws Exception {
//        int postId = 1;
//        List<Comment> comments = List.of(new Comment(), new Comment());
//
//        when(commentService.getCommentsByPostId(postId)).thenReturn(comments);
//
//        mockMvc.perform(get("/api/comments/post/{postId}", postId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0]").exists())
//                .andExpect(jsonPath("$[1]").exists());
//    }
//
//    @Test
//    void testGetCommentById() throws Exception {
//        int commentId = 1;
//        Comment comment = new Comment();
//        comment.setId(commentId);
//        comment.setContent("Test comment content");
//
//        when(commentService.getCommentById(commentId)).thenReturn(comment);
//
//        mockMvc.perform(get("/api/comments/{id}", commentId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(commentId))
//                .andExpect(jsonPath("$.content").value("Test comment content"));
//    }
//
//    @Test
//    void testUpdateComment() throws Exception {
//        int commentId = 1;
//        Comment comment = new Comment();
//        comment.setId(commentId);
//        comment.setContent("Updated comment content");
//
//        when(commentService.updateComment(eq(commentId), any(Comment.class))).thenReturn(comment);
//
//        mockMvc.perform(put("/api/comments/{id}", commentId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(comment)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value("Updated comment content"));
//    }
//
//    @Test
//    void testDeleteComment() throws Exception {
//        int commentId = 1;
//
//        doNothing().when(commentService).deleteComment(commentId);
//
//        mockMvc.perform(delete("/api/comments/{id}", commentId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//}
