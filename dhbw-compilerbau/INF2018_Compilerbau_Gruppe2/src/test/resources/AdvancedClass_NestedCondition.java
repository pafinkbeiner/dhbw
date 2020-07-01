class AdvancedClass_NestedCondition
{
      char nesting(boolean controll, int calculator)
      {
          if(controll != true)
          {
              if (calculator == 0)
              {
                  calculator = 10;
                  return 'n';
              } else
              {
                  calculator = 3;
                  return 'y';
              }
          } else
          {
              return 'n';
          }
      }
}