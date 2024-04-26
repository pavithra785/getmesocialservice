package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.service.AlbumService;
import com.example.getmesocialservice.service.CommentService;
import com.example.getmesocialservice.service.FirebaseService;
import com.example.getmesocialservice.validation.ValidName;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping
    public List<Comment> getCommentList(){
        return commentService.getCommentList();
    }

    @PostMapping
    public Comment saveComment(@RequestBody @Valid Comment comment,@RequestHeader(name="idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return  commentService.saveComment(comment);
        }
       return null;
    }


    @GetMapping("/find")
    public Optional<Comment> getCommentById(@RequestParam(name = "commentId") String commentId) {
        return commentService.getCommentById(commentId);
    }

    @PutMapping
    public Comment updateComment(@RequestBody @Valid Comment comment,@RequestHeader(name="idToken")String idToken ) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return commentService.updateComment(comment);
        }
        return null;
    }

    @DeleteMappingcd
    public void deleteComment( @RequestParam (name = "commentId") String commentId,@RequestHeader(name="idToken")String idToken ) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            commentService.deleteComment(commentId);
        }

    }
}
