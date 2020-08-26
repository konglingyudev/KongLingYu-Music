package com.imooc.lib_audio.mediaplayer.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import com.gentek.lib_audio.mediaplayer.model.SongBean;
import com.gentek.lib_audio.mediaplayer.db.DaoSession;
import com.gentek.lib_audio.mediaplayer.db.SongBeanDao;
import com.gentek.lib_audio.mediaplayer.db.FavouriteDao;

/**
 * 收藏表
 */
@Entity
public class Favourite {

    @Id(autoincrement = true)
    Long favouriteId;
    @NotNull
    String songId;
    //一条收藏记录唯一对应一条实体
    @ToOne(joinProperty = "songId")
    SongBean songBean;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1743949577)
    private transient FavouriteDao myDao;
    @Generated(hash = 414208758)
    public Favourite(Long favouriteId, @NotNull String songId) {
        this.favouriteId = favouriteId;
        this.songId = songId;
    }
    @Generated(hash = 1933414424)
    public Favourite() {
    }
    public Long getFavouriteId() {
        return this.favouriteId;
    }
    public void setFavouriteId(Long favouriteId) {
        this.favouriteId = favouriteId;
    }
    public String getSongId() {
        return this.songId;
    }
    public void setSongId(String songId) {
        this.songId = songId;
    }
    @Generated(hash = 1925570906)
    private transient String songBean__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1939779148)
    public SongBean getSongBean() {
        String __key = this.songId;
        if (songBean__resolvedKey == null || songBean__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SongBeanDao targetDao = daoSession.getSongBeanDao();
            SongBean songBeanNew = targetDao.load(__key);
            synchronized (this) {
                songBean = songBeanNew;
                songBean__resolvedKey = __key;
            }
        }
        return songBean;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 852390586)
    public void setSongBean(@NotNull SongBean songBean) {
        if (songBean == null) {
            throw new DaoException(
                    "To-one property 'songId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.songBean = songBean;
            songId = songBean.getSong_id();
            songBean__resolvedKey = songId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1142028328)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFavouriteDao() : null;
    }
}
