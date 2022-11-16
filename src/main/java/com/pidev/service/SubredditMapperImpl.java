package com.pidev.service;

import com.pidev.dto.SubredditDto;
import com.pidev.dto.SubredditDto.SubredditDtoBuilder;
import com.pidev.mapper.SubredditMapper;
import com.pidev.models.Subreddit;
import com.pidev.models.Subreddit.SubredditBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-12T05:34:58+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Service
public class SubredditMapperImpl implements SubredditMapper {

    @Override
    public SubredditDto mapSubredditToDto(Subreddit subreddit) {
        if ( subreddit == null ) {
            return null;
        }

        SubredditDtoBuilder subredditDto = SubredditDto.builder();

        subredditDto.id( subreddit.getId() );
        subredditDto.name( subreddit.getName() );
        subredditDto.description( subreddit.getDescription() );

        subredditDto.postCount( mapPosts(subreddit.getPosts()) );

        return subredditDto.build();
    }

    @Override
    public Subreddit mapDtoToSubreddit(SubredditDto subreddit) {
        if ( subreddit == null ) {
            return null;
        }

        SubredditBuilder subreddit1 = Subreddit.builder();

        subreddit1.id( subreddit.getId() );
        subreddit1.name( subreddit.getName() );
        subreddit1.description( subreddit.getDescription() );

        return subreddit1.build();
    }
}