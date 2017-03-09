public class Matrix
{
  int[][] matrix = null;

  BufferedReader buffer = new BufferedReader(new FileReader(matrix1));
  BufferedReader buffer = new BufferedReader(new FileReader(matrix2));

  String line;
  int row = 0;
  int size = 0;

  public Matrix(int row, int col, int value)
  {
    row = m_row;
    col = m_col;
    value = m_value;

  }


  public void getCellTotal()
  {

  }

  public void getRows()
  {
    while ((line = buffer.readLine()) != null)
    {
        String[] vals = line.trim().split("\\s+");

        if (matrix == null)
        {
            size = vals.length;
            matrix = new int[size][size];
        }

        for (int col = 0; col < size; col++)
        {
            matrix[row][col] = Integer.parseInt(vals[col]);
        }
        row++;
    }
  }

  public void getCols()
  {
    while ((line = buffer.readLine()) != null)
     {
        String[] vals = line.trim().split("\\s+");

        if (matrix == null) {
            size = vals.length;
            matrix = new int[size][size];
        }

        for (int row = 0; row < size; row++) {
            matrix[row][col] = Integer.parseInt(vals[row]);
        }
        col++;
    }

  }

  public void getCell(row, col)
  {
    return row;
    return col;
  }

  public void setCell(row, col, value)
  {
    m_row + m_col = m_value;
  }

  public void toString()
  {

  }

}
