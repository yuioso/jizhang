package com.demo.account.mapper;

import com.demo.account.entity.Bill;
import com.demo.account.vo.BillVO;
import org.apache.ibatis.annotations.*;
import java.util.List;



@Mapper
public interface BillMapper {



    /**
     * 新增账单
     */
    @Insert("""
    
    insert into bill
    (
        user_id,
        category_id,
        amount,
        type,
        remark,
        bill_time
    )

    values
    (
        #{userId},
        #{categoryId},
        #{amount},
        #{type},
        #{remark},
        #{billTime}
    )

    """)
    int insert(Bill bill);




    /**
     * 查询用户账单
     */
    @Select("""
    
    select

    b.id,
    c.name category_name,
    b.amount,
    b.type,
    b.remark,
    b.bill_time


    from bill b


    left join category c

    on b.category_id=c.id


    where b.user_id=#{userId}


    order by b.bill_time desc


    """)
    List<BillVO> findList(
            Long userId
    );



    /**
     * 删除账单
     */
    @Delete("""
    
    delete from bill

    where id=#{id}

    and user_id=#{userId}

    """)
    int delete(
            Long id,
            Long userId
    );






    /**
     * 修改账单
     */
    @Update("""
    
    update bill

    set

    category_id=#{categoryId},

    amount=#{amount},

    type=#{type},

    remark=#{remark},

    bill_time=#{billTime}


    where id=#{id}

    """)
    int update(Bill bill);

    /**
     * 分页查询账单
     */
    List<BillVO> pageList(
            Long userId,
            Long start,
            Long size
    );


}

