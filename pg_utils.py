def open_db():
    import psycopg2 as pg
    con = pg.connect(
        host="localhost",
        port='5433',
        database="dbms",
        user="postgres",
        password="")
    cur = con.cursor()
    return con, cur

def open_rvuniv():
    import psycopg2 as pg
    con = pg.connect(
        host="localhost",
        port='5433',
        database="RVUniv",
        user="postgres",
        password="")
    cur = con.cursor()
    return con, cur

def open_lib():
    import psycopg2 as pg
    con = pg.connect(
        host="localhost",
        port='5433',
        database="Library",
        user="postgres",
        password="")
    cur = con.cursor()
    return con, cur


def list_tables(cur):
    cur.execute("""SELECT table_name FROM information_schema.tables
       WHERE table_schema = 'public'""")
    tables = [t[0] for t in cur.fetchall()]
    return tables
