import { TodoCompletPipe } from './todo-complet.pipe';

describe('TodoCompletPipe', () => {
  it('create an instance', () => {
    const pipe = new TodoCompletPipe();
    expect(pipe).toBeTruthy();
  });
});
