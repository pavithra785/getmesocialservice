package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.service.AlbumService;
import com.example.getmesocialservice.service.CommentService;
import com.example.getmesocialservice.validation.ValidName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getCommentList(){
        return commentService.getCommentList();
    }

    @PostMapping
    public Comment saveComment(@RequestBody @Valid Comment comment){
        return  commentService.saveComment(comment);
    }


    @GetMapping("/find")
    public Optional<Comment> getCommentById(@RequestParam(name = "commentId") String commentId) {
        return commentService.getCommentById(commentId);
    }

    @PutMapping
    public Comment updateComment(@RequestBody @Valid Comment comment ){
        return commentService.updateComment(comment);
    }

    @DeleteMapping
    public void deleteComment( @RequestParam (name = "commentId") String commentId ){
        commentService.deleteComment(commentId);
    }
}
