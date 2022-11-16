 package com.pidev.mapper;

 import com.pidev.dto.SubredditDto;
 import com.pidev.models.Post;
 import com.pidev.models.Subreddit;
 import org.mapstruct.InheritInverseConfiguration;
 import org.mapstruct.Mapper;
 import org.mapstruct.Mapping;

 import java.util.List;



@Mapper(componentModel = "ubredditMapper")
public interface SubredditMapper {

    @Mapping(target = "postCount", expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);
    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);
}