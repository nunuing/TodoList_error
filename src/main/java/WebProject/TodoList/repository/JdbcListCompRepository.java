package WebProject.TodoList.repository;

import WebProject.TodoList.domain.ListComp;
import org.springframework.boot.jdbc.*;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcListCompRepository implements ListRepository {
    private final DataSource dataSource;

    public JdbcListCompRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ListComp save(ListComp comp) {
        String sql = "insert into list(content) values(?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, comp.getContent());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                comp.setNum(rs.getLong(1));
            } else {
                throw new SQLException("num 조회 실패");
            }

            return comp;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<ListComp> findByNum(Long num) {
        String sql = "select * from list where num = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, num);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                ListComp comp = new ListComp();
                comp.setNum(rs.getLong("num"));
                comp.setContent(rs.getNString("content"));
                comp.setDone(rs.getInt("done"));
                return Optional.of(comp);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<ListComp> findAll() {
        String sql = "select * from list";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            List<ListComp> listComps = new ArrayList<>();
            while (rs.next()) {
                ListComp listComp = new ListComp();
                listComp.setNum(rs.getLong("num"));
                listComp.setContent(rs.getNString("content"));
                listComp.setDone(rs.getInt("done"));
                listComps.add(listComp);
            }

            return listComps;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (pstmt != null)
                pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

}
